module "echo-api" {
  source = "../../../../../aws-ref-arch/terraform/canary"

  subnet_ids         = [
    "subnet-1f359c33",
    "subnet-e47116ac",
  ]

  lb_security_group  = "sg-a0df2ed1"
  app_security_group = "sg-47df2e36"
  key_name           = "tg_key"
  app_port           = "8080"
  asg_max            = "3"
  asg_min            = "1"
  asg_desired        = "1"
  app_name           = "${var.app_name}"
  ping_path          = "/echo/"
  instance_type      = "t2.micro"
  live_image         = "${var.live_image}"
  dark_image         = "${var.dark_image}"
  shared_kms_key     = "57b7e9e3-50a7-4f11-9731-b4b399e9558e"
  hbc_banner         = "s5a"
  hbc_group          = "producty"
  hbc_env            = "stqa"

  env_vars           = {
    APP_NAME                  = "${var.app_name}"
    HBC_BANNER                = "s5a"
    HBC_ENV                   = "stqa"
    NEW_RELIC_LICENSE_KEY     = "${var.NEW_RELIC_LICENSE_KEY}"
    NEW_RELIC_APP_NAME        = "${var.NEW_RELIC_APP_NAME}"
  }
}

module "cpu_alarm" {
  source    = "cloudwatch/cpu-alarm"

  app_name  = "${module.echo-api.live_component["app_name"]}"
  asg_name  = "${module.echo-api.live_component["asg_name"]}"
  component = "${module.echo-api.live_component["component"]}"
}

module "health_alarm" {
  source    = "cloudwatch/health-alarm"

  component = "${module.echo-api.live_component["component"]}"
  asg_min   = "${var.asg_min}"
  lb_name   = "${module.echo-api.live_component["elb_name"]}"
  app_name  = "${module.echo-api.live_component["app_name"]}"
}

module "logging_alarm" {
  source    = "cloudwatch/logging-alarm"

  app_name  = "${module.echo-api.live_component["app_name"]}"
  component = "${module.echo-api.live_component["component"]}"
  log_group = "${module.echo-api.live_component["log_group"]}"
}

terraform {
  backend "s3" {
    bucket = "rogue-infra"
    key    = "terraform/concourse/echo-api"
    region = "us-east-1"
  }
}

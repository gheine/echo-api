variable "live_image" {
  type        = "string"
  description = "Concourse placeholder for live echo-api image"
}

variable "dark_image" {
  type        = "string"
  description = "Concourse placeholder for dark echo-api image"
}

variable "NEW_RELIC_LICENSE_KEY" {
  type        = "string"
  description = "New relic license key"
}

variable "NEW_RELIC_APP_NAME" {
  type        = "string"
  description = "New relic app name"
}

variable "app_name" {		
  default = "echo-api"
}

variable "asg_min" {
  default = "1"
}

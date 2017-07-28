#!/usr/bin/env bash

set -ex

# Destroy Toggle Service
cd app
terraform destroy -force \
      -var live_image=hbc-docker.jfrog.io/echo-api:v3 \
      -var dark_image=hbc-docker.jfrog.io/echo-api:v3 \
      -var NEW_RELIC_LICENSE_KEY="foo" \
      -var NEW_RELIC_APP_NAME="bar"
rm -rf ./.terraform
rm -rf ./*.tfstate*


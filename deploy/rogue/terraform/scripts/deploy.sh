#!/usr/bin/env bash

set -ex

tag=$1

# echo-api deploy
ls -l
cd app
terraform init
terraform env new ${TF_ENV} &>/dev/null || terraform env select ${TF_ENV}
terraform apply \
      -var live_image=hbc-docker.jfrog.io/echo-api:$tag \
      -var dark_image=hbc-docker.jfrog.io/echo-api:$tag \
      -var NEW_RELIC_LICENSE_KEY=${NEW_RELIC_LICENSE_KEY} \
      -var NEW_RELIC_APP_NAME=${NEW_RELIC_APP_NAME}

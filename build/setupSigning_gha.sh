#!/usr/bin/env bash
set -x

echo "Importing signing key..."
gpg --quiet --batch --yes --decrypt --passphrase="$SIGNING_PASSPHRASE" -- output ./build/signing.key ./build/signing.key.gpg

gpg --version
gpg --no-tty --batch --yes --import ./build/signing.key
rm build/signing.key

echo "Signing key import finished!"

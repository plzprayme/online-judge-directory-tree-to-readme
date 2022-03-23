#!/bin/sh

echo "::set-output name=list::$(ls)"
echo "::set-output name=cur::$(pwd)"
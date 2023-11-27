#!/bin/sh

set -e

psql -U postgres -d postgres -p 5434 -c "CREATE DATABASE a3_menor_custo WITH ENCODING='UTF8' OWNER=postgres CONNECTION LIMIT=-1;"
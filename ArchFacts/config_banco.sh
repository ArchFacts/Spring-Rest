#!/bin/bash

DB_HOST=${RDS_HOST}
DB_PORT=${RDS_PORT:-3306}
DB_DATABASE=${RDS_DATABASE}
DB_USER=${RDS_USER}
DB_PASSWORD=${RDS_PASSWORD}
SCHEMA_FILE="/app/schema.sql"

echo "Tentando aplicar schema do banco de dados no ${DB_HOST}:${DB_PORT}/${DB_DATABASE}..."
mysql -h $DB_HOST -P $DB_PORT -u $DB_USER -p$DB_PASSWORD -D $DB_DATABASE < $SCHEMA_FILE

if [ $? -eq 0 ]; then
    echo "Comando de aplicacao do schema executado."
else
   echo "falha ao aplicar o schema"
fi

echo "Iniciando a aplicação backend..."

exec "$@"
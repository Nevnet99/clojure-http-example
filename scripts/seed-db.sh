# Only seed the DB
cat "../src/db/seed.sql" | docker exec -i clojure-http-example-local-dbs psql -h localhost -U postgres -f-

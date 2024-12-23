# Run and create a docker container with postgres installed for local development
docker run -d --name clojure-http-example-local-dbs -p 5432:5432 -e POSTGRES_PASSWORD=mysecretpassword postgres;
# Seed the DBs based off the seed script for local development
cat "../src/db/seed.sql" | docker exec -i clojure-http-example-local-dbs psql -h localhost -U postgres -f-

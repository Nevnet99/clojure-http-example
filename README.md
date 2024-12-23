# clojure-http

An example repo learning how to build a HTTP server with Clojure, featuring a local db that gets seeded
to make local development much easier. 

## Installation

install deps
`lein deps`

create and run a local docker instance of postgres for local development
`bash ./scripts/run-and-seed-db.sh`

runs the HTTP server
`lein run`

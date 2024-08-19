## Prime Numbers Selector
(Sorry for the basic implementation)


## How to run
In selector dir run `docker compose up build`

## Producer
In order to generate random numbers - `localhost:8181/generate-numbers`
The result will be written to numbers.csv file, on a volume created by
docker compose. Volume name will be "selector_my-volume"

## Consumer
In order to select the generated prime numbers - `localhost:8182/select-prime`
The result will be written to prime_numbers.csv file, on the same volume.

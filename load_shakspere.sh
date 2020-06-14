#!/bin/bash
#The data files are in ~/Downloads
#The credentials for search-movies-lb3ddlzrpzgw7ppcifpgzwrnby.us-east-1.es.amazonaws.com are in ~/.netrc

#Example command to load index shakspere 
#/usr/bin/curl -n 'Content-Type: application/x-ndjson' -XPOST 'https://search-movies-lb3ddlzrpzgw7ppcifpgzwrnby.us-east-1.es.amazonaws.com/shakespeare/_doc/_bulk?pretty' --data-binary @shakespeare_6.0.json

/usr/bin/curl -n -H 'Content-Type: application/x-ndjson' -XPOST 'https://search-movies-lb3ddlzrpzgw7ppcifpgzwrnby.us-east-1.es.amazonaws.com/_bulk?pretty' --data-binary @logs.jsonl








#!/bin/bash
/usr/bin/curl -n -X PUT https://search-movies-lb3ddlzrpzgw7ppcifpgzwrnby.us-east-1.es.amazonaws.com/log -H 'Content-Type: application/json' -d'
{
 "mappings": {
      "properties": {
        "geo": {
          "properties": {
            "coordinates": {
              "type": "geo_point"
            }
          }
        }
      }
   }
}
'

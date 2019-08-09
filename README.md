# DiscoveryClient

export VCAP_SERVICES=`cat vcap.json`

export VCAP_APPLICATION="{'app.Id':'foo'}"

java -jar target/DiscoveryClient-0.0.1-SNAPSHOT.jar --server.port=9006 --spring.profiles.active=cloud


## vcap.json (from appmanager env variables)
```
{
      "p-service-registry": [
        {
          "label": "p-service-registry",
          "provider": null,
          "plan": "standard",
          "name": "spring-cloud-registry",
          "tags": [
            "eureka",
            "discovery",
            "registry",
            "spring-cloud"
          ],
          "instance_name": "spring-cloud-registry",
          "binding_name": null,
          "credentials": {
            "client_secret": "redacted",
            "uri": "https://eureka-4e75bdc1-dfca-4f84-915d-74d40b4df7e9.apps.pcfone.io",
            "client_id": "redacted",
            "access_token_uri": "https://p-spring-cloud-services.uaa.run.pcfone.io/oauth/token"
          },
          "syslog_drain_url": null,
          "volume_mounts": []
        }
      ]
}
```


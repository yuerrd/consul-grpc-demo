## Spring Boot Consul gRPC Example

#### Docker Install Consul

```shell
docker volume create consul-data
```

  ```sh
docker run -id --name=consul -p 8300:8300 -p 8301:8301 -p 8302:8302 -p 8500:8500 -p 8600:8600 -v consul-data:/consul/data consul agent -server -ui -node=n1 -bootstrap-expect=1 -client=0.0.0.0 -advertise=${PrivateIP}

  ```

[Consul ports reference | Consul | HashiCorp Developer](https://developer.hashicorp.com/consul/docs/install/ports)


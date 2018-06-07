# superboot-core
superboot-core 是 superboot 框架系列的核心框架.

该框架是基于 Springboot 框架, 结合 SpringMVC, Spring, Hibernate, SpringDataJPA 等框架进行二次封装而成.

该框架的目的是为了让程序员花最少的时间, 用更少而更规范的代码, 快速地写出更少bug的后台接口.

## Controller 层
控制层使用的是 SpringMVC, 为了规范开发, 所有接口请求方式都使用 POST, contentType 均为 application/json.

以下为 Controller 类的一个模版:
```java
@RestController
public class UserController {

	@Autowired
	private UserService service;

	@PostMapping("/addUser")
	public ResultMessage addUser(@RequestBody UserParam param) throws Exception {
		return service.addUser(param.getUser());
	}

}
```
使用注意事项:
- Controller 类均声明` @RestController` 注解, 默认使用 JSON 请求以及返回数据.
- 一个 Controller 编写的是某一小模块的所有接口. 如用户模块的接口: `addUser, getUser, getUserList, removeUser`等.
- 一个 Controller 类最多仅对应一个 Service 类, 每一个 Controller 接口方法最多仅对应一个 Service 方法.
- Controller 仅处理数据, 不处理业务逻辑.
- `@PostMapping` 参数值即为接口名.
- `@RequestBody Param param` 接收请求参数 Param.
- 返回结果统一封装 ResultMessage.

### Param 封装请求参数
Controller 中的接口方法均通过 `@RequestBody` 接收请求参数, 封装进 Param 对象中

以下为 Param 类的一个模版:
```java
public class UserParam extends CoreParam {
	private UserPo user;

	public UserPo getUser() {
		return user;
	}

	public void setUser(UserVo user) {
		this.user = user;
	}
}
```
该模版能接收的数据类型 application/json :
```JSON
{
  "user" : {
    "username" : "l-kaxy"
  }
}
```

使用注意事项:
- 一般情况下, 尽量每一个 Controller 类对应一个 Param, 如 UserController 对应一个 UserParam 类. 接收所有来自该 Controller 的请求数据.
- 模版中仅示例接收一个 user 对象, 需要接收其它请求请自行声明并添加对应的 Getter 和 Setter.

### ResultMessage
响应统一的结果消息 (无结果数据):
```JSON
{
  "serviceResult": 1,
  "resultInfo": "添加成功",
  "resultParm": null
}
```
- `serviceResult` : 结果码.
- `resultInfo` : 结果信息.
- `resultParm` : 结果数据, 没有结果数据时则为`null`, 数据格式统一为 `Map` 类型, 其中的`value` 可为任意类型 (Object).

响应统一的结果消息 (有结果数据):
```JSON
{
  "serviceResult": 1,
  "resultInfo": "获取成功",
  "resultParm": {
    "userList": [
      {
        "userid" : 1,
        "username" : "l-kaxy"
      },
      {
        "userid" : 2,
        "username" : "Jason"
      }
    ],
    "user" : {
      "userid" : 1,
      "username" : "l-kaxy"
    },
    "username" : "l-kaxy"
  }
}
```
以上例子展示了三种结果类型, 集合类型 `userList`,普通对象类型 `user` 和字符串类型 `username`.

## Service 层
// TODO

## Repository 层
// TODO

## 持久化实体
// TODO

## License
```
Copyright 2018 L-kaxy

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```

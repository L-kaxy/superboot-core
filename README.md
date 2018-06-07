# superboot-core
superboot-core 是 superboot 框架系列的核心框架.

该框架是基于 Springboot 框架, 结合 SpringMVC, Spring, Hibernate, SpringDataJPA 等框架进行二次封装而成.

该框架的目的是为了让程序员花最少的时间, 用更少而更规范的代码, 快速地写出更少bug的后台接口.

## Controller 层
控制层使用的是 SpringMVC, 为了规范开发, 所有接口请求方式都使用 POST, contentType 均为 **application/json**.

以下为 Controller 类的一个模版:

	@RestController
	public class UserController {

		@Autowired
		private UserService service;

		@PostMapping("/addUser")
		public ResultMessage addUser(@RequestBody Param param) throws Exception {
			UserPo userPo = param.getUser().voToPo(UserPo.class);
			return service.addUser(userPo);
		}

	}

使用注意事项:

Controller 类均声明 @RestController 注解, 默认使用 JSON 请求以及返回数据.

一个 Controller 编写的是某一小模块的所有接口. 如用户模块: addUser, getUser, getUserList, removeUser等.


















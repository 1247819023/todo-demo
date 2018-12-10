<template>
	<div id="app">
		<h1>任务列表</h1>
		<div>
			<input v-model="todo.name" placeholder="name"></input>
			<input v-model="todo.detail" placeholder="detail"></input>
			<input v-model="todo.createdAt" type="date" placeholder="createdAt"></input>
			<input v-model="todo.finishedAt" type="date" placeholder="finishedAt"></input>
			<input v-model="todo.state" placeholder="state" />
			<input v-model="todo.memo" placeholder="memo" />
			<button @click="submit">提交</button>
		</div>

		<div id="news">
			<ul>
				<li class="bt">编号</li>
				<li class="bt">姓名</li>
				<li class="bt">任务</li>
				<li class="bt">开始日期</li>
				<li class="bt">结束日期</li>
				<li class="bt">完成情况</li>
				<li class="bt">备注</li>
				<li class="bt">操作</li>
			</ul>
			<ul v-for="todo in todos">
				<li>{{todo.id}}</li>
				<li>{{todo.name}}</li>
				<li>{{todo.detail}}</li>
				<li>{{todo.createdAt}}</li>
				<li>{{todo.finishedAt}}</li>
				<li>{{todo.state}}</li>
				<li>{{todo.memo}}</li>
				<li>
					<button @click="del" :data-id="todo.id">删除</button>
				</li>
			</ul>
		</div>
	</div>
</template>

<script>
	export default {
		name: 'app',
		data() {
			return {
				todos: [],
				todo: {
					name: '',
					detail: '',
					createdAt: '',
					finishedAt: '',
					state: '',
					memo: ''
				},
				id: '{{todo.memo}}'
			}
		},
		methods: {
			submit() {
				console.log(this.todo);
				fetch('http://localhost:8080/todo', {
						method: 'post',
						headers: {
							"Content-Type": "application/json"
						},
						body: JSON.stringify(this.todo)
					}).then(resp => resp.json(), location.reload())
					.then(data => {
						this.todos = data;
					});
			},
			del(e) {
				var id = e.currentTarget.dataset.id;


				fetch('http://localhost:8080/todo/del/' + id, {
						method: 'get',
					})
					.then(resp => resp.json(), location.reload())
					.then(data => {
						this.todos = data;

					});
			}
		},
		created() {
			fetch('http://localhost:8080/todo', null)
				.then(resp => resp.json())
				.then(data => {
					this.todos = data
				});
		}
	}
</script>

<style>
	#app {
		font-family: 'Avenir', Helvetica, Arial, sans-serif;
		-webkit-font-smoothing: antialiased;
		-moz-osx-font-smoothing: grayscale;
		text-align: center;
		color: #2c3e50;
		margin-top: 60px;
	}

	#news {
		width: 900px;
		margin: auto;
	}

	#news li {
		list-style-type: none;
		float: left;
		width: 100px;
		text-align: center;
		background: #ccc;
		margin-right: 2px;
		margin-bottom: 2px;
		line-height: 30px;
		font-size: 14px;
	}

	#news li.bt {
		font-size: 16px;
		font-weight: bold;
		background: #999;
	}
</style>

<template>
	<div id="insert">
		<input v-model="todo.name" placeholder="name"></input>
		<input v-model="todo.detail" placeholder="detail"></input>
		<input v-model="todo.createdAt" type="date" placeholder="createdAt"></input>
		<input v-model="todo.finishedAt" type="date" placeholder="finishedAt"></input>
		<input v-model="todo.state" placeholder="state" />
		<input v-model="todo.memo" placeholder="memo" />
		<button @click="submit">提交</button>
	</div>
</template>

<script>
	export default {
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
			}
		}
	}
</script>

<style>

</style>

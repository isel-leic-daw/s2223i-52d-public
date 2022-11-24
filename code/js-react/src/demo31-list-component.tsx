import React from 'react'
import { createRoot } from 'react-dom/client'

type TaskModel = {
    id :number,
    text : string
}

const tasks : Array<TaskModel>= [
    {id : 1, text : "task1"},
    {id : 2, text : "task2"}
]

let nextId=2

//function Task(props){
function Task({taskModel} : {taskModel : TaskModel}){
    return (
        <div >
            <p>Id : {taskModel.id}</p>
            <p>Name : {taskModel.text}</p>
            <input type="text"></input>
        </div>)

        
}

function TasksList({tks} : {tks : Array<TaskModel>} ){
    return (
        <div>
            <h1>Tasks</h1>
            {tks.map(t => (<Task key = {t.id} taskModel={t}/>))}
              
        </div>
    )
}

export function demo(){
    const root = createRoot(document.getElementById("container"))
    root.render(<TasksList tks={tasks}/>)
    setInterval( ()=> {
        ++nextId
        tasks.unshift({id : nextId, text : `tasks ${nextId}`})
        root.render(<TasksList tks={tasks}/>)},
        5000)
} 

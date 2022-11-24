import React from 'react'
import ReactDOM from 'react-dom'

type TaskModel = {
    id :number,
    text : string
}

const tasks = [
    {id : 1, text : "task1"},
    {id : 2, text : "task2"}
]

let nextId=2

function render(tks : Array<TaskModel> ){
    return (
        <div>
            <h1>Tasks</h1>
            {
                tks.map(t =>
                    (
                       <div key = {t.id}>
                            <p>Id : {t.id}</p>
                            <p>Name : {t.text}</p>
                            <input type="text"></input>
                        </div>
                    )
                )
            }
        </div>
    )
}

export function demo(){
    setInterval( ()=> {
        ++nextId
        tasks.push({id : nextId, text : `tasks ${nextId}`})
        ReactDOM.render(render(tasks), document.getElementById("container"))},
        2000)
} 

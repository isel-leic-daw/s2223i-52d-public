import React from 'react'
import ReactDOM from 'react-dom'

let counter = 0

function render(){
    ++counter
    return (
        <div>
            <p>Temos de estudar</p>
            <p>PDM</p>
            <p>{counter}</p>
            <input type="text"></input>
        </div>
    )
}

export function demo(){
    setInterval( ()=>
    ReactDOM.render(render(), document.getElementById("container")),
    2000)
} 



import React from 'react'
import ReactDOM from 'react-dom'

const virtualTree1 = 
    React.createElement('div', {},
        React.createElement('p',{},"Temos de estudar"),
        React.createElement('p',{},"DAW"))

const virtualTree2 = 
        <div>
            <p>Temos de estudar</p>
            <p>PDM</p>
        </div>



export function demo(){
    setInterval( ()=>
    ReactDOM.render(virtualTree2, document.getElementById("container")),
    2000)
} 
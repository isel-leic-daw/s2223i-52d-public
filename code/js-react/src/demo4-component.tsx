import React from 'react'
import { createRoot } from 'react-dom/client'

function Component1(props){
    console.log("Component1")
    return ( 
        <div>
            <h1>Hello World {props.name}</h1>
            {props.children}
        </div>
    )
}

function Component2(props){
    console.log("Component2")
    return (
        <div>
            <Component1 name = {props.name}>
                <p>Must Study</p>
            </Component1>
        </div>

    )
}

export function demo(){
    let counter = 0
    const root = createRoot(document.getElementById("container"))
    root.render(<Component2 name={counter}/>)

    //setInterval(()=>root.render(<Component2 name={++counter}/>), 1000)
}
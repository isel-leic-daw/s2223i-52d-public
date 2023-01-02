import React from 'react'
import { memo } from "react"

function CounterWithButton(props){
    console.log(props.name)
    return (
        <div>
            <p>{props.name} = {props.counter}</p>
            <button onClick={()=>props.inc()}>Increment With Button</button>
        </div>
    )
}

export default memo(CounterWithButton)
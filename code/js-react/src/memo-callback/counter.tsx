import React from 'react'
import { memo } from "react"


function Counter(props){
    console.log(props.name)
    return (
        <div>
            <p>{props.name} = {props.counter}</p>
        </div>
    )
}

export default memo(Counter)

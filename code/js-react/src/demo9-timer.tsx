import React, { useEffect } from 'react'
import { createRoot } from 'react-dom/client'

function Timer(){
    
    const [counter, setCounter] = React.useState(0)
    const [period, setPeriod] = React.useState(1000)

    useEffect(() =>{
        const tid = setInterval(()=>{
            setCounter(currentState =>currentState + 1)
            console.log("Timer")
        }, period)
        return ()=>{
            clearInterval(tid)
        }
    }, [period])
    

    return (
        <div>
            <h1>{counter}</h1>
            <p><button onClick={()=>setPeriod(period + 500)}>+</button></p>
            <p>{period}</p>
            <p><button onClick={()=>setPeriod(period - 500)}>-</button></p>
        </div>
    )
}

export function demo(){
    const root = createRoot(document.getElementById("container"))
    root.render(<Timer />)
    setTimeout(()=> root.render(<p>New Element</p>), 2000 )
}

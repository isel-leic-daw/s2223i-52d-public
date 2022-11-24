import React from 'react'
import { createRoot } from 'react-dom/client'

function Counter(){
    const [counter, setCounter] = React.useState(0)
    function add(){setCounter(counter + 1)}
    function sub(){setCounter(counter - 1)}
    return (
        <div>
            <p><button onClick={add}>+</button></p>
            <p>{counter}</p>
            <p><button onClick={sub}>-</button></p>
        </div>
    )
}

function App(){
    const [secondCounter, setSecondCounter] = React.useState(true)
    return (
        <div>
            <Counter />
            {secondCounter ? (<Counter />) : (<p>Removed</p>) }
            <p>
                <input
                    type="checkbox"
                    checked={secondCounter}
                    onChange={e => {setSecondCounter(e.target.checked)}}
                />
                Show second counter 
            </p>
            
        </div>
    )
}

export function demo(){
    const root = createRoot(document.getElementById("container"))
    root.render(<App />)
}
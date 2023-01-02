import React, {useCallback, useState } from 'react'
import { createRoot } from 'react-dom/client'
import Counter from './counter'
import CounterWithButton from './counterWithButton'


function Component(){
    const [counter1, setCounter1] = useState(0)
    const [counter2, setCounter2] = useState(0)

    //const incrementCounter1 = ()=>setCounter1(counter1 + 1)
    const incrementCounter2 = ()=>setCounter2(counter2 + 1)

    const incrementCounter1 = useCallback(()=>setCounter1(counter1 + 1), [counter1])

    return (
        <div>
            <CounterWithButton inc={incrementCounter1} name="Counter1" counter={counter1} />
            <Counter name="Counter2" counter={counter2} />
            <button onClick={()=>incrementCounter2()}>Increment</button>
        </div>     
    )
}

export function demo(){
    const root = createRoot(document.getElementById("container"))
    root.render(<Component />)
}
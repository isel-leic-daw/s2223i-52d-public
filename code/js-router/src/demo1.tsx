import React from 'react'
import { createRoot } from 'react-dom/client'
import {
    createBrowserRouter,
    RouterProvider,
    Link,
    useParams
  } from "react-router-dom";

const router = createBrowserRouter(
    [
        {
            path : "/",
            element : < Home />
        },
        {
            path : "/path1",
            element : < CompPath1 />
        },
        {
            path : "/path2",
            element : < CompPath2 />
        },
        {
            path : "/students/:id",
            element : < StudentsDetails />
        },

    ]

)

function Home(){

    return (
        <div>
            <h1>"Home"</h1>
            <p><a href="/path1" >Path1 (using a) </a></p>
            <p><Link to="/path1">Path1</Link> </p>
            <p><Link to="/path2">Path2</Link> </p>
            <p><Link to="/students/10">Student 10</Link> </p>
        </div>
        
    )
}

function CompPath1(){

    return (
        <div>
            <h1>"CompPath1"</h1>
            <p><Link to="/">Home</Link> </p>
        </div>
        
    )
}

function CompPath2(){

    return (
        <div>
            <h1>"CompPath2"</h1>
            <p><Link to="/">Home</Link> </p>
        </div>
        
    )
}

function StudentsDetails(){
    const { id } = useParams();
    return (
        <div>
            <h1>"Students details"</h1>
            <p> Student ID = {id} </p>
            <p><Link to="/">Home</Link> </p>
        </div>
        
    )
}




export function demo(){
    const root = createRoot(document.getElementById("container"))
    root.render(<RouterProvider router={router} />)
} 



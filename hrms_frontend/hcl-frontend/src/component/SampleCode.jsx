import React, { useState, useEffect } from 'react'


function SampleCode({ empdata }) {
    const [counter, setCounter] = useState(20)
    const [pointer, setPointer] = useState(100)


    useEffect(() => {

        console.log("counter=" + counter)
        console.log("pointer=" + pointer)
    }, [counter, pointer])

    function changeCounter() {
        setCounter(counter + 1)

    }
    function changePointer() {
        setPointer(pointer - 1)
    }
    return (
        // <div>
        //     <h2>Employee details</h2>
        //     <div>
        //         <h3>Name:{empdata.ename}</h3>
        //         <h3>Empid:{empdata.empid}</h3>

        //     </div>
        // </div>




        <div>
            <h2>Counter value={counter}</h2>
            <h2>Pointer value={pointer}</h2>
            <button onClick={changeCounter}>Counter</button>
            <button onClick={changePointer}>Pointer</button>

        </div>
    )
}

export default SampleCode
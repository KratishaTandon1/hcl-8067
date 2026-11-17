import './App.css'
import { BrowserRouter, Routes, Route } from 'react-router-dom'
import Home from './component/Home'
import Login from './component/Login'
import Registeration from './component/Registeration'
import Dashboard from './component/Dashboard'
import Attendance from './component/Attendance' // <-- 1. Ye import add karein

function App() {
  return (
    <>
      <div>
        <BrowserRouter>
          <Routes>
            <Route path="/" element={<Home />} />
            <Route path="/login" element={<Login />} />
            <Route path="/registeration" element={<Registeration />} />
            <Route path="/dashboard" element={<Dashboard />} />
            <Route path="/attendance" element={<Attendance />} /> {/* <-- 2. Ye route add karein */}
          </Routes>
        </BrowserRouter>
      </div>
    </>
  )
}

export default App
import React from 'react'
import { createRoot } from 'react-dom/client'
import { BrowserRouter, Routes, Route, Link } from 'react-router-dom'
import Alunos from './pages/Alunos'
import Cursos from './pages/Cursos'
import Home from './pages/Home'
import './styles.css'

function App() {
  return (
    <BrowserRouter>
      <nav className="nav">
        <Link to="/">Home</Link>
        <Link to="/alunos">Alunos</Link>
        <Link to="/cursos">Cursos</Link>
      </nav>
      <Routes>
        <Route path="/" element={<Home/>} />
        <Route path="/alunos" element={<Alunos/>} />
        <Route path="/cursos" element={<Cursos/>} />
      </Routes>
    </BrowserRouter>
  )
}

createRoot(document.getElementById('root')).render(<App />)

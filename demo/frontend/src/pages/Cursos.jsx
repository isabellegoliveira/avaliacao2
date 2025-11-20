import React, {useEffect, useState} from 'react'
import api from '../services/api'

export default function Cursos(){
  const [cursos, setCursos] = useState([])
  const [form, setForm] = useState({nome:'', cargaHoraria:0})

  useEffect(()=>{ load() },[])

  function load(){
    api.get('/cursos').then(res=>setCursos(res.data)).catch(()=>setCursos([]))
  }

  function submit(e){
    e.preventDefault()
    api.post('/cursos', {...form, cargaHoraria: Number(form.cargaHoraria)}).then(()=>{ setForm({nome:'',cargaHoraria:0}); load() })
  }

  return (
    <div className="container">
      <h3>Cursos</h3>
      <form onSubmit={submit} className="form">
        <input placeholder="Nome" value={form.nome} onChange={e=>setForm({...form,nome:e.target.value})}/>
        <input placeholder="Carga Horária" value={form.cargaHoraria} onChange={e=>setForm({...form,cargaHoraria:e.target.value})}/>
        <button type="submit">Criar</button>
      </form>
      <ul>
        {cursos.map(c=>(
          <li key={c.id}>{c.nome} — {c.cargaHoraria}h</li>
        ))}
      </ul>
    </div>
  )
}

import React, {useEffect, useState} from 'react'
import api from '../services/api'

export default function Alunos(){
  const [alunos, setAlunos] = useState([])
  const [form, setForm] = useState({nome:'', email:'', matricula:''})

  useEffect(()=>{ load() },[])

  function load(){
    api.get('/alunos').then(res=>setAlunos(res.data)).catch(()=>setAlunos([]))
  }

  function submit(e){
    e.preventDefault()
    api.post('/alunos', form).then(()=>{ setForm({nome:'',email:'',matricula:''}); load() })
  }

  return (
    <div className="container">
      <h3>Alunos</h3>
      <form onSubmit={submit} className="form">
        <input placeholder="Nome" value={form.nome} onChange={e=>setForm({...form,nome:e.target.value})}/>
        <input placeholder="Email" value={form.email} onChange={e=>setForm({...form,email:e.target.value})}/>
        <input placeholder="Matrícula" value={form.matricula} onChange={e=>setForm({...form,matricula:e.target.value})}/>
        <button type="submit">Criar</button>
      </form>
      <ul>
        {alunos.map(a=>(
          <li key={a.id}>{a.nome} — {a.email} — {a.matricula}</li>
        ))}
      </ul>
    </div>
  )
}

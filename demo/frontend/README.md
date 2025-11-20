# Frontend - Sistema Acadêmico (React + Vite)

Frontend simples consumindo o backend. Configurado para rodar em `http://localhost:5173`.

## Como rodar
```bash
cd frontend
npm install
npm run dev
```

## Notas
- Ajuste `src/services/api.js` caso o backend esteja em outro host/porta.
- Autenticação básica: o frontend não implementa formulário de login; para rodar em modo autenticado ajuste endpoints ou implemente fluxo JWT/Keycloak.

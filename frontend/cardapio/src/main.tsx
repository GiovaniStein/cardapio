import { QueryClient, QueryClientProvider } from '@tanstack/react-query';
import React from 'react'
import ReactDOM from 'react-dom/client'
import App from './App'
import './index.css'

const queryCliente = new QueryClient();

ReactDOM.createRoot(document.getElementById('root') as HTMLElement).render(
  <React.StrictMode>
    <QueryClientProvider client={queryCliente}>
      <App />
    </QueryClientProvider>
  </React.StrictMode>,
)

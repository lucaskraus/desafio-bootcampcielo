import { Routes, Route } from 'react-router-dom';
import { Dashboard } from './pages/dashboard';
import { Feedback } from './pages/feedback';

export function Router(){
  return (
    <Routes>
      <Route path="/" element={<Dashboard/>} />
      <Route path="/feedback" element={<Feedback/>} />
    </Routes>
  )
}
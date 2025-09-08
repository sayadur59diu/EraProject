import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import CustomerPage from './pages/CustomerPage';

function App() {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<h1 className="text-2xl font-bold text-center mt-4">Welcome to Nano Banking UI</h1>} />
        <Route path="/customers" element={<CustomerPage />} />
      </Routes>
    </Router>
  );
}

export default App;

import React from 'react';
import CustomerForm from '../components/CustomerForm';

const CustomerPage = () => {
  return (
    <div className="p-4">
      <h1 className="text-2xl font-bold mb-4">Customer Profile</h1>
      <CustomerForm />
    </div>
  );
};

export default CustomerPage;
import React, { useState } from 'react';
import axios from 'axios';

const CustomerForm = () => {
  const [formData, setFormData] = useState({
    firstName: '',
    lastName: '',
    dateOfBirth: '',
    gender: '',
    email: '',
    phoneNumber: '',
    addressLine1: '',
    addressLine2: '',
    city: '',
    state: '',
    postalCode: '',
    country: '',
    accountType: '',
    preferredLanguage: '',
    loyaltyProgramStatus: '',
    notes: ''
  });

  const handleChange = (e) => {
    setFormData({ ...formData, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const response = await axios.post('http://localhost:8081/api/customers', formData);
      alert('Customer created successfully!');
      setFormData({
        firstName: '',
        lastName: '',
        dateOfBirth: '',
        gender: '',
        email: '',
        phoneNumber: '',
        addressLine1: '',
        addressLine2: '',
        city: '',
        state: '',
        postalCode: '',
        country: '',
        accountType: '',
        preferredLanguage: '',
        loyaltyProgramStatus: '',
        notes: ''
      });
    } catch (error) {
      console.error(error);
      alert('Error creating customer');
    }
  };
// Ensure fields are displayed vertically by using flex-col
// (already handled by space-y-3 on the form, but you can wrap inputs in divs for clarity)
return (
    <form onSubmit={handleSubmit} className="max-w-xl mx-auto p-4 space-y-3 border rounded shadow flex flex-col">
        <h2 className="text-xl font-bold mb-4">Customer Profile</h2>

        <div>
            <label className="block font-medium mb-1" htmlFor="firstName">First Name</label>
            <input
                id="firstName"
                type="text"
                name="firstName"
                value={formData.firstName}
                onChange={handleChange}
                placeholder="First Name"
                className="w-full p-2 border rounded"
            />
        </div>
        <div>
            <label className="block font-medium mb-1" htmlFor="lastName">Last Name</label>
            <input
                id="lastName"
                type="text"
                name="lastName"
                value={formData.lastName}
                onChange={handleChange}
                placeholder="Last Name"
                className="w-full p-2 border rounded"
            />
        </div>
        <div>
            <label className="block font-medium mb-1" htmlFor="dateOfBirth">Date of Birth</label>
            <input
                id="dateOfBirth"
                type="date"
                name="dateOfBirth"
                value={formData.dateOfBirth}
                onChange={handleChange}
                placeholder="Date of Birth"
                className="w-full p-2 border rounded"
            />
        </div>
        <div>
            <label className="block font-medium mb-1" htmlFor="gender">Gender</label>
            <select
                id="gender"
                name="gender"
                value={formData.gender}
                onChange={handleChange}
                className="w-full p-2 border rounded"
            >
                <option value="">Select Gender</option>
                <option value="M">Male</option>
                <option value="F">Female</option>
                <option value="O">Other</option>
            </select>
        </div>
        <div>
            <label className="block font-medium mb-1" htmlFor="email">Email</label>
            <input
                id="email"
                type="email"
                name="email"
                value={formData.email}
                onChange={handleChange}
                placeholder="Email"
                className="w-full p-2 border rounded"
            />
        </div>
        <div>
            <label className="block font-medium mb-1" htmlFor="phoneNumber">Phone Number</label>
            <input
                id="phoneNumber"
                type="text"
                name="phoneNumber"
                value={formData.phoneNumber}
                onChange={handleChange}
                placeholder="Phone Number"
                className="w-full p-2 border rounded"
            />
        </div>
        <style>
            {`
                #addressLine1, #addressLine2 {              
                    width: 1024px;
                    font-size: 1.125rem;
                }
            `}
        </style>
        <div>
            <label className="block font-medium mb-1" htmlFor="addressLine1">Address Line 1</label>
            <input
                id="addressLine1"
                type="text"
                name="addressLine1"
                value={formData.addressLine1}
                onChange={handleChange}
                placeholder="Address Line 1"
                className="w-full p-2 border rounded"
            />
        </div>
        <div>
            <label className="block font-medium mb-1" htmlFor="addressLine2">Address Line 2</label>
            <input
                id="addressLine2"
                type="text"
                name="addressLine2"
                value={formData.addressLine2}
                onChange={handleChange}
                placeholder="Address Line 2"
                className="w-full p-2 border rounded"
            />
        </div>
        <div>
            <label className="block font-medium mb-1" htmlFor="city">City</label>
            <input
                id="city"
                type="text"
                name="city"
                value={formData.city}
                onChange={handleChange}
                placeholder="City"
                className="w-full p-2 border rounded"
            />
        </div>
        <div>
            <label className="block font-medium mb-1" htmlFor="state">State</label>
            <input
                id="state"
                type="text"
                name="state"
                value={formData.state}
                onChange={handleChange}
                placeholder="State"
                className="w-full p-2 border rounded"
            />
        </div>
        <div>
            <label className="block font-medium mb-1" htmlFor="postalCode">Postal Code</label>
            <input
                id="postalCode"
                type="text"
                name="postalCode"
                value={formData.postalCode}
                onChange={handleChange}
                placeholder="Postal Code"
                className="w-full p-2 border rounded"
            />
        </div>
        <div>
            <label className="block font-medium mb-1" htmlFor="country">Country</label>
            <input
                id="country"
                type="text"
                name="country"
                value={formData.country}
                onChange={handleChange}
                placeholder="Country"
                className="w-full p-2 border rounded"
            />
        </div>
        <div>
            <label className="block font-medium mb-1" htmlFor="accountType">Account Type</label>
            <select
                id="accountType"
                name="accountType"
                value={formData.accountType}
                onChange={handleChange}
                className="w-full p-2 border rounded"
            >
                <option value="">Select Account Type</option>
                <option value="Savings">Savings</option>
                <option value="Current">Current</option>
                <option value="FixedDeposit">Fixed Deposit</option>
            </select>
        </div>
        <div>
            <label className="block font-medium mb-1" htmlFor="preferredLanguage">Preferred Language</label>
            <input
                id="preferredLanguage"
                type="text"
                name="preferredLanguage"
                value={formData.preferredLanguage}
                onChange={handleChange}
                placeholder="Preferred Language"
                className="w-full p-2 border rounded"
            />
        </div>
        <div>
            <label className="block font-medium mb-1" htmlFor="loyaltyProgramStatus">Loyalty Program Status</label>
            <select
                id="loyaltyProgramStatus"
                name="loyaltyProgramStatus"
                value={formData.loyaltyProgramStatus}
                onChange={handleChange}
                className="w-full p-2 border rounded"
            >
                <option value="">Select Loyalty Status</option>
                <option value="Bronze">Bronze</option>
                <option value="Silver">Silver</option>
                <option value="Gold">Gold</option>
            </select>
        </div>
        <div>
            <label className="block font-medium mb-1" htmlFor="notes">Notes</label>
            <textarea
                id="notes"
                name="notes"
                value={formData.notes}
                onChange={handleChange}
                placeholder="Notes"
                className="w-full p-2 border rounded"
            ></textarea>
        </div>
        <button type="submit" className="bg-blue-500 text-white px-4 py-2 rounded">Submit</button>
    </form>
);
};

export default CustomerForm;
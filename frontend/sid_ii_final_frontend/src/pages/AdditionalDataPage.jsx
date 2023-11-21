import React from 'react'
import Nav from '../components/Nav';
import UserDetailForm from '../components/UserDetailForm';

const AdditionalDataPage = () => {

  const handleLogout = () => {
    window.location.href = '/'; 
  };

  return (
    <div>
        <Nav></Nav>
        <UserDetailForm></UserDetailForm>
    </div>
  )
}

export default AdditionalDataPage
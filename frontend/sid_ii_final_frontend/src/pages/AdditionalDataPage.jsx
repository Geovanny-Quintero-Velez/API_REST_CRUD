import React from 'react'
import Nav from '../components/Nav';
import UserDetailForm from '../components/UserDetailForm';
import {addDetail} from '../config/api'

const AdditionalDataPage = () => {

  const handleLogout = () => {
    window.location.href = '/'; 
  };

  return (
    <div>
        <Nav></Nav>
        <UserDetailForm addDetail={addDetail}></UserDetailForm>
    </div>
  )
}

export default AdditionalDataPage
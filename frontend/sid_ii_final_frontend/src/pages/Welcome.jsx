import React from 'react'
import Nav from '../components/Nav';
import WelcomeOptions from '../components/WelcomeOptions'

const Welcome = () => {

  const isTokenAvailable = localStorage.getItem('token') !== null;

  const handleLogout = () => {
    localStorage.removeItem('token');
    window.location.href = '/'; 
  };

  return (
    <div>
        <Nav></Nav>
        <WelcomeOptions></WelcomeOptions>
    </div>
  )
}

export default Welcome
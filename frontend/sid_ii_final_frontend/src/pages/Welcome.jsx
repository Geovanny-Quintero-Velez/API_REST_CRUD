import React from 'react'
import Nav from '../components/Nav';
import WelcomeOptions from '../components/WelcomeOptions'

const Welcome = () => {

  const handleLogout = () => {
    localStorage.removeItem('user');
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
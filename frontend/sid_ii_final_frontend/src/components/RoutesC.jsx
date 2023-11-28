import React from 'react';
import { BrowserRouter as Router, Route, Routes, Navigate } from 'react-router-dom';
import { ToastContainer } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';

import Login from './Login';
import Welcome from '../pages/Welcome';
import AdditionalDataPage from '../pages/AdditionalDataPage';
import OrderPage from '../pages/OrderPage';
import OrderDetailPage  from '../pages/OrderDetailPage';
import ListOrderPage from '../pages/ListOrderPage';

function isToken(){
  const tok = localStorage.getItem('token')
  return tok !== null
}

const ProtectedRoute = ({ element }) => {
  return isToken() ? element : <Navigate to="/login" />;
};


const RoutesC = () => {
  return (
    <Router>
      <Routes>
        <Route path="/login" element={<Login></Login>} />
        <Route path='/' element={<Navigate to='/login'></Navigate>}></Route>
        <Route
          path="/*"
          element={
            <ProtectedRoute
              element={<Routes>
                <Route path="/welcome" element={<Welcome></Welcome>} />
                <Route path="/addData" element={<AdditionalDataPage></AdditionalDataPage>} />
                <Route path="/makeOrder" element={<OrderPage></OrderPage>} />
                <Route path="/listOrders" element={<ListOrderPage></ListOrderPage>} />
                <Route path="/Order/:id" element={<OrderDetailPage></OrderDetailPage>} />
              </Routes>}
            />
          }
        />
      </Routes>
      <ToastContainer />
    </Router>
  );
};

export default RoutesC;
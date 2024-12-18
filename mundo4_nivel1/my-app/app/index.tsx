import React from 'react';
import { SupplierProvider } from '../src/context/SupplierContext';
import SupplierList from '../src/screens/SupplierList';

const Index = () => {
  return (
    <SupplierProvider>
      <SupplierList />
    </SupplierProvider>
  );
};

export default Index;

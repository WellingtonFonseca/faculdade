import React from 'react';
import CadastroForm from '../src/screens/CadastroForm';
import { SupplierProvider } from '../src/context/SupplierContext';

const Cadastro = () => {
  return (
    <SupplierProvider>
      <CadastroForm />
    </SupplierProvider>
  );
};

export default Cadastro;

import { Slot } from 'expo-router';
import { SupplierProvider } from '../src/context/SupplierContext';

export default function Layout() {
  return (
    <SupplierProvider>
      <Slot />
    </SupplierProvider>
  );
}

import React from 'react';
import { SafeAreaView } from 'react-native';
import Cat from '../src/components/Cat';

const Index = () => {
  return (
    <SafeAreaView style={{ flex: 1, justifyContent: 'center', alignItems: 'center' }}>
      <Cat />
    </SafeAreaView>
  );
};

export default Index;

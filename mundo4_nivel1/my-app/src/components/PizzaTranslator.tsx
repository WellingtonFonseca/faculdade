import React, { useState } from 'react';
import { View, Text, TextInput, StyleSheet } from 'react-native';

const PizzaTranslator = () => {
  const [text, setText] = useState('');

  return (
    <View style={styles.container}>
      <TextInput
        style={styles.input}
        placeholder="Type here to translate!"
        onChangeText={(newText) => setText(newText)}
      />
      <Text style={styles.output}>
        {text
          .split(' ')
          .map((word) => word && '🍕')
          .join(' ')}
      </Text>
    </View>
  );
};

const styles = StyleSheet.create({
  container: {
    padding: 10,
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
  },
  input: {
    height: 40,
    borderColor: 'gray',
    borderWidth: 1,
    width: '80%',
    paddingHorizontal: 8,
    marginBottom: 10,
  },
  output: {
    padding: 10,
    fontSize: 42,
    textAlign: 'center',
  },
});

export default PizzaTranslator;

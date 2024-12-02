import React from 'react';
import { Image, ScrollView, Text, StyleSheet } from 'react-native';

const logo = {
  uri: 'https://reactnative.dev/img/tiny_logo.png',
  width: 64,
  height: 64,
};

const ScrollableList = () => (
  <ScrollView contentContainerStyle={styles.container}>
    <Text style={styles.largeText}>Scroll me plz</Text>
    {[...Array(5)].map((_, i) => (
      <Image key={`logo-top-${i}`} source={logo} style={styles.image} />
    ))}

    <Text style={styles.largeText}>If you like</Text>
    {[...Array(5)].map((_, i) => (
      <Image key={`logo-mid-${i}`} source={logo} style={styles.image} />
    ))}

    <Text style={styles.largeText}>Scrolling down</Text>
    {[...Array(5)].map((_, i) => (
      <Image key={`logo-bottom-${i}`} source={logo} style={styles.image} />
    ))}

    <Text style={styles.largeText}>What's the best</Text>
    {[...Array(5)].map((_, i) => (
      <Image key={`logo-best-${i}`} source={logo} style={styles.image} />
    ))}

    <Text style={styles.largeText}>Framework around?</Text>
    {[...Array(5)].map((_, i) => (
      <Image key={`logo-react-${i}`} source={logo} style={styles.image} />
    ))}

    <Text style={styles.smallText}>React Native</Text>
  </ScrollView>
);

const styles = StyleSheet.create({
  container: {
    alignItems: 'center',
    paddingVertical: 20,
  },
  largeText: {
    fontSize: 96,
    textAlign: 'center',
    marginVertical: 20,
  },
  smallText: {
    fontSize: 80,
    textAlign: 'center',
    marginVertical: 20,
  },
  image: {
    width: 64,
    height: 64,
    margin: 5,
  },
});

export default ScrollableList;

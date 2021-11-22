<template>
  <div class="notification is-primary">
      <p>{{ result }}</p>
  </div>
</template>

<script>
export default {
  props: {
    result: [Object, String, Array]
  }
};
</script>

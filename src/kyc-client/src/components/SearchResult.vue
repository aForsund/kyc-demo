<template>
  <div class="mt-1 mb-1">
      <button class="button is-small is-primary">{{ result }}</button>
  </div>
</template>

<script>
export default {
  props: {
    result: [Object, String, Array]
  }
};
</script>
